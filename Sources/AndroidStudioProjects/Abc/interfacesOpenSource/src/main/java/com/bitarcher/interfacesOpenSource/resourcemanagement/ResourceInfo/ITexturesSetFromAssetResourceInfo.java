package com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo;

import com.bitarcher.interfacesOpenSource.resourcemanagement.Access.IAssetsBase;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;

/**
 * Created by michel on 12/01/15.
 */
public interface ITexturesSetFromAssetResourceInfo<TOneAssetTexture extends IOneAssetTexture>  extends ITexturesSetResourceInfo<TOneAssetTexture>, IAssetsBase{
}
