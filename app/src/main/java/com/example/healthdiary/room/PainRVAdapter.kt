package com.example.healthdiary.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthdiary.R

class PainRVAdapter(
    val context: Context,
    val painClickDeleteInterface: PainClickDeleteInterface,
    val painClickInterface: PainClickInterface
) :
    RecyclerView.Adapter<PainRVAdapter.ViewHolder>() {

    // on below line we are creating a
    // variable for our all Pains list.
    private val allPains = ArrayList<Pain>()

    // on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are creating an initializing all our
        // variables which we have added in layout file.
        val PainTV = itemView.findViewById<TextView>(R.id.idTVPain)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.pain_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // on below line we are setting data to item of recycler view.
        holder.PainTV.setText(allPains.get(position).painDescription)
        holder.dateTV.setText("---> Last Updated <--- : " + allPains.get(position).date)
        // on below line we are adding click listener to our delete image view icon.
        holder.deleteIV.setOnClickListener {
            // on below line we are calling a Pain click
            // interface and we are passing a position to it.
            painClickDeleteInterface.onDeleteIconClick(allPains.get(position))
        }

        // on below line we are adding click listener
        // to our recycler view item.
        holder.itemView.setOnClickListener {
            // on below line we are calling a Pain click interface
            // and we are passing a position to it.
            painClickInterface.onPainClick(allPains.get(position))
        }
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our list size.
        return allPains.size
    }

    // below method is use to update our list of Pains.
    fun updateList(newList: List<Pain>) {
        // on below line we are clearing
        // our Pains array list
        allPains.clear()
        // on below line we are adding a
        // new list to our all Pains list.
        allPains.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }
}

interface PainClickDeleteInterface {
    // creating a method for click
    // action on delete image view.
    fun onDeleteIconClick(pain: Pain)
}

interface PainClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onPainClick(pain: Pain)
}


