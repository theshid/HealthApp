package com.example.healthapp.app.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.healthapp.R
import com.example.healthapp.data.Consultation

class ConsultationAdapter:ListAdapter<Consultation, ConsultationAdapter.ConsultationViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Consultation>() {
            override fun areItemsTheSame(
                oldItem: Consultation,
                newItem: Consultation
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Consultation,
                newItem: Consultation
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_consultation, parent, false)
        return ConsultationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultationViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ConsultationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.nameDisplay)
        private val date: TextView = itemView.findViewById(R.id.dateDisplay)


        @SuppressLint("StringFormatInvalid")
        fun bind(item: Consultation) {
            name.text = "Name: ${item.name}"
            date.text = "Date: ${item.date}"


            /*itemClicked.setOnClickListener {
                if (discLayout.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(
                        motherLayout,
                        AutoTransition()
                    )
                    discLayout.visibility = View.VISIBLE
                    motherLayout.setBackgroundColor(Color.parseColor("#E9EBEE"))
                    arrowIcon.setImageResource(R.drawable.ic_up_arrow)
                } else {
                    TransitionManager.beginDelayedTransition(
                        motherLayout,
                        AutoTransition()
                    )
                    discLayout.visibility = View.GONE
                    motherLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    arrowIcon.setImageResource(R.drawable.ic_down_arrow)
                }
            }*/
        }


    }
}


