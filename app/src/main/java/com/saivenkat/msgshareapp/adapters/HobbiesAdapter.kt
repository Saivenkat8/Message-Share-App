package com.saivenkat.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saivenkat.msgshareapp.R
import com.saivenkat.msgshareapp.models.Hobbies
import com.saivenkat.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter (val context: Context , private val hobbies: List<Hobbies>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent ,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby , position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var currentHobby : Hobbies? = null
        private var currentPosition :Int = 0
        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + "Clicked !")
                }
            }
            itemView.imgShare.setOnClickListener {
                currentHobby?.let{
                    val message : String = "My Hobby is" + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT , message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent,"Please Select an app :"))
                }
            }
        }
        fun setData (hobby : Hobbies?, pos:Int){
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }
            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}