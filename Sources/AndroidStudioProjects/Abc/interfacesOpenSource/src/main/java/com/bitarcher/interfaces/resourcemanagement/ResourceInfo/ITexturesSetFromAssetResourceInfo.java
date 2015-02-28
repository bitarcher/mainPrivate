package com.bitarcher.interfaces.resourcemanagement.ResourceInfo;

import com.bitarcher.interfaces.resourcemanagement.Access.IAssetsBase;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.List;

/**
 * Created by michel on 12/01/15.
 */
public interface ITexturesSetFromAssetResourceInfo<TOneAssetTexture extends IOneAssetTexture>  extends ITexturesSetResourceInfo<TOneAssetTexture>, IAssetsBase{
}
