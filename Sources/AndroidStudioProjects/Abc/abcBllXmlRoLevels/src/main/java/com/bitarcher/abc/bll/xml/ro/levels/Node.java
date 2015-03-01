package com.bitarcher.abc.bll.xml.ro.levels;

import com.bitarcher.aeFun.bll.xml.abc.ro.levels.INode;
import com.bitarcher.aeFun.interfaces.mvc.ILabeledListener;
import com.bitarcher.aeFun.interfaces.mvc.ITreeNode;
import com.bitarcher.aeFun.interfaces.mvc.ITreeNodeListener;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 20/01/15.
 */
public class Node implements INode {
    ITreeNode parent;
    ArrayList<ITreeNode> childNodes;
    String name;
    String notTranslatedLabel;
    String translatedLabel;
    ArrayList<ITreeNodeListener> treeNodeListeners;
    ArrayList<ILabeledListener> labeledListeners;

    public Node(ITreeNode parent) {
        this.parent = parent;

        this.childNodes = new ArrayList<>();
        this.treeNodeListeners = new ArrayList<>();
        this.labeledListeners = new ArrayList<>();
    }

    public Node(ITreeNode parent, String name, String notTranslatedLabel) {
        this(parent);
        this.name = name;
        this.notTranslatedLabel = notTranslatedLabel;
    }

    @Override
    public ITreeNode getParent() {
        return this.parent;
    }

    @Override
    public List<ITreeNode> getChildNodes() {
        return this.childNodes;
    }

    @Override
    public void addTreeNodeListener(ITreeNodeListener listener) {
        this.treeNodeListeners.add(listener);
    }

    @Override
    public void removeTreeNodeListener(ITreeNodeListener listener) {
        this.treeNodeListeners.remove(listener);
    }

    @Override
    public String getPath() {
        String retval = "";

        if(this.parent != null)
        {
            if(this.parent.getParent() != null)
            {
                retval = this.parent.getPath() + "/" + this.name;
            }
            else
            {
                retval = "/" + this.name;
            }
        }
        else
        {
            retval = "/";
        }


        return retval;
    }

    protected String translate(String fmt, Object... args)
    {
        return BabelModuleAgglomeratorSingleton.getInstance().translate(this, fmt, args);
    }

    @Override
    public String getTranslatedLabel() {

        if(this.translatedLabel == null) {
            this.translatedLabel = this.translate(this.notTranslatedLabel);
        }

        return this.translatedLabel;
    }

    @Override
    public void addLabeledListener(ILabeledListener labeled) {
        this.labeledListeners.add(labeled);
    }

    @Override
    public void removeLabeledListener(ILabeledListener labeled) {
        this.labeledListeners.remove(labeled);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void fromXml(Element element) {
        this.name = element.getAttribute("name)");
        this.notTranslatedLabel = element.getAttribute("notTranslatedLabel)");

        for (org.w3c.dom.Node childNode = element.getFirstChild(); childNode != null; ) {
            org.w3c.dom.Node nextChild = childNode.getNextSibling();
            // Do something with childNode, including move or delete...

            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;

                String name = childElement.getNodeName();

                if(name == "Node") {

                    Node cn = new Node(this);

                    cn.fromXml(childElement);

                    this.childNodes.add(cn);
                }
            }

            childNode = nextChild;
        }
    }
}
