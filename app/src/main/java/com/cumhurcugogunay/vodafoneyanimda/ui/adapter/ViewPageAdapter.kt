package com.cumhurcugogunay.vodafoneyanimda.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cumhurcugogunay.vodafoneyanimda.data.entity.Tarifelerim
import com.cumhurcugogunay.vodafoneyanimda.databinding.KullanimlarimRowBinding

class ViewPageAdapter (var mContext: Context,private var tarifelerim: List<Tarifelerim>): RecyclerView.Adapter<ViewPageAdapter.KullanimHolder>(){

    inner class KullanimHolder(var binding: KullanimlarimRowBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KullanimHolder {
        val binding = KullanimlarimRowBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return KullanimHolder(binding)
    }

    override fun getItemCount(): Int {
        return tarifelerim.size
    }

    override fun onBindViewHolder(holder: KullanimHolder, position: Int) {
        val tarife = tarifelerim[position]
        val t = holder.binding

        t.tarifeAdi.text = tarife.tarifeAd
        t.sonTarih.text = tarife.sonTarih
        t.ToplamGb.text = gb(tarife.toplamGb,tarife.sinirsiz)
        t.gbKalan.text = gb(tarife.kalanGb,tarife.sinirsiz)
        if(gb(tarife.kalanGb,tarife.sinirsiz)=="Sınırsız"){
            t.gbKalanDevami.text = ""
            t.toplamGbDevami.text = ""
        }
        t.progressBarKullanim.progress = progressBarCalculator(tarife.toplamGb,tarife.kalanGb,tarife.sinirsiz)
    }

    fun progressBarCalculator(toplamGb:Int,gbKalan:Double,sinirsiz:Boolean):Int{
        if(sinirsiz){
            return 100
        }else{
            val p = (gbKalan/toplamGb)*100
            return p.toInt()
        }
    }
    fun gb(toplamGb: Int,sinirsiz: Boolean):String{
        if(sinirsiz){
            return "Sınırsız"
        }
        else{
            return toplamGb.toString()
        }
    }
    fun gb(toplamGb: Double,sinirsiz: Boolean):String{
        if(sinirsiz){
            return "Sınırsız"
        }
        else{
            return toplamGb.toString()
        }
    }
}