package com.bitarcher.interfaces.bll.xml.abc.ro.resources;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.basicioc.IXmlReader;

import java.util.Map;
import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface ILetters extends IXmlReader {
    List<ILetter> getLetterList();

    Map<Character, ILetter> getLetterByChar(char c);
}
