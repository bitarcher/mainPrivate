package com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo;

import com.bitarcher.interfacesProtected.resourcemanagement.Access.IAssetsBase;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;

/**
 * Created by michel on 12/01/15.
 */
public interface ITexturesSetFromAssetResourceInfo<TOneAssetTexture extends IOneAssetTexture>  extends ITexturesSetResourceInfo<TOneAssetTexture>, IAssetsBase{
}
