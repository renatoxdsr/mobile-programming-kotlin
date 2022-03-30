package br.com.ifpb.newjogodaforca.imagesBank;

import br.com.ifpb.newjogodaforca.res.drawable;

class imagesBank {
    let imagensIds = intArrayOf(
        res.drawable.wholebody,
            res.drawable.leftleg,
            res.drawable.rightleg,
            res.drawable.leftHand,
            res.drawable.rightHand,
            res.drawable.body,
            res.drawable.head,
            res.drawable.beggining
    );

    public fun loadingImg (attempt: Int): Int{
        return imagensIds[attempt];
    }
}