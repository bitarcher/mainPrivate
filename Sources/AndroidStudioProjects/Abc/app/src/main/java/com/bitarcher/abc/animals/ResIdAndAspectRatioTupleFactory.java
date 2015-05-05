package com.bitarcher.abc.animals;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.abc.R;
import com.bitarcher.aeFun.interfaces.basicioc.ITFactory;

/**
 * Created by michel on 30/04/15.
 */
public class ResIdAndAspectRatioTupleFactory implements ITFactory<ResIdAndAspectRatioTuple,EnumAnimal> {
    @Override
    public ResIdAndAspectRatioTuple make(EnumAnimal enumAnimal) {
        ResIdAndAspectRatioTuple retval = null;

        switch (enumAnimal)
        {
            case abeille:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_abeille, 240f/286f);
                break;
            case autruche:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_autruche, 240f/351f);
                break;
            case baleine:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_baleine, 240f/101f);
                break;
            case belette:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_belette, 240f/323f);
                break;
            case canard:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_canard, 240f/351f);
                break;
            case castor:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_castor, 240f/290f);
                break;
            case chat:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_chat, 240f/377f);
                break;
            case chauve_souris:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_chauve_souris, 240f/122f);
                break;
            case cheval:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_cheval, 240f/286f);
                break;
            case chevre:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_chevre, 240f/282f);
                break;
            case chien:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_chien, 240f/322f);
                break;
            case coccinelle:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_coccinelle, 240f/279f);
                break;
            case cochon:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_cochon, 240f/279f);
                break;
            case crocodile:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_crocodile, 240f/569f);
                break;
            case dromadaire:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_dromadaire, 240f/202f);
                break;
            case ecureuil:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_ecureuil, 240f/319f);
                break;
            case elan:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_elan, 240f/162f);
                break;
            case elephant:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_elephant, 240f/229f);
                break;
            case escargot:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_escargot, 240f/126f);
                break;
            case fourmi:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_fourmi, 240f/263f);
                break;
            case girafe:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_girafe, 240f/450f);
                break;
            case gnu:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_gnu, 240f/319f);
                break;
            case grenouille:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_grenouille, 240f/239f);
                break;
            case hibou:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_hibou, 240f/235f);
                break;
            case hippopotame:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_hippopotame, 240f/296f);
                break;
            case homard:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_homard, 240f/204f);
                break;
            case ibis:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_ibis, 240f/256f);
                break;
            case jaguar:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_jaguar, 240f/111f);
                break;
            case jaseur:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_jaseur, 240f/215f);
                break;
            case kangourou:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_kangourou, 240f/282f);
                break;
            case koala:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_koala, 240f/283f);
                break;
            case koudou:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_koudou, 240f/335f);
                break;
            case lama:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_lama, 240f/559f);
                break;
            case lapin:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_lapin, 240f/376f);
                break;
            case leopard:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_leopard, 240f/380f);
                break;
            case loup:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_loup, 240f/534f);
                break;
            case morse:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_morse, 240f/212f);
                break;
            case mouche:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_mouche, 240f/248f);
                break;
            case mouton:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_mouton, 240f/250f);
                break;
            case narval:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_narval, 240f/141f);
                break;
            case ours:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_ours, 240f/324f);
                break;
            case paon:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_paon, 240f/202f);
                break;
            case papillon:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_papillon, 240f/208f);
                break;
            case pieuvre:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_pieuvre, 240f/218f);
                break;
            case pingouin:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_pingouin, 240f/240f);
                break;
            case poule:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_poule, 240f/388f);
                break;
            case quetzal:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_quetzal, 240f/279f);
                break;
            case requin:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_requin, 240f/108f);
                break;
            case rhinoceros:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_rhinoceros, 240f/276f);
                break;
            case serpent:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_serpent, 240f/315f);
                break;
            case singe:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_singe, 240f/197f);
                break;
            case souris:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_souris, 240f/237f);
                break;
            case taupe:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_taupe, 240f/181f);
                break;
            case tigre:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_tigre, 240f/377f);
                break;
            case tortue:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_tortue, 240f/117f);
                break;
            case unau:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_unau, 240f/287f);
                break;
            case vache:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_vache, 240f/272f);
                break;
            case wapiti:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_wapiti, 240f/224f);
                break;
            case xerus:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_xerus, 240f/273f);
                break;
            case yak:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_yak, 240f/214f);
                break;
            case zebre:
                retval = new ResIdAndAspectRatioTuple(R.drawable.svg_animal_zebre, 240f/286f);
                break;

            default:
                throw new RuntimeException("Not implemented animal resIds and aspect ratio " + enumAnimal.name());
        }

        return retval;
    }
}
