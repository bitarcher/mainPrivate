package com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo;

import com.bitarcher.interfaces.interfaces.resourcemanagement.Access.IAssetsBase;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;

/**
 * Created by michel on 12/01/15.
 */
public interface ITexturesSetFromAssetResourceInfo<TOneAssetTexture extends IOneAssetTexture>  extends ITexturesSetResourceInfo<TOneAssetTexture>, IAssetsBase{
}
