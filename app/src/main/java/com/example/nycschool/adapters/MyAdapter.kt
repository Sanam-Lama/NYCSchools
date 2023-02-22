package com.example.nycschool.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschool.databinding.ItemViewBinding
import com.example.nycschool.models.SchoolItem

/**
 * an adapter class is a necessary class for us to bind our data to UI while displaying the
 * items in recyclerview. Here, we bind the data that is coming from api or database and
 * help t display to the view
 */

class MyAdapter(private val context: Context, private val schoolList: String): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
//class MyAdapter(private val context: Context, private val schoolList: List<SchoolItem>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val schools = schoolList[position]
        holder.binding.schoolName.text = schools.toString()
    }

    override fun getItemCount(): Int {
        return schoolList.length
    }


    class MyViewHolder( val binding: ItemViewBinding ) : RecyclerView.ViewHolder(binding.root) {
//       fun bind() {
//           binding.schoolName.text = schools[1].school_name
//       }
    }
}