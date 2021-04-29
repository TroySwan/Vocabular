/**
 * List adapter to convert database dictionary items to card objects to be shown in a list
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.dictionary

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import uk.ac.aber.dcs.cs31620.vocabular.databinding.DictionaryItemCardBinding
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class DictionaryRecyclerWithListAdapter(
    private val context: Context?,
    val listener: OnDeleteClickListener
) :
    RecyclerView.Adapter<DictionaryRecyclerWithListAdapter.ViewHolder>() {

    interface OnDeleteClickListener {
        fun onDeleteClick(dictionaryItem: DictionaryItem)
    }

    private var dataSet: MutableList<DictionaryItem> = mutableListOf()


    inner class  ViewHolder(
        itemView: View,
        val wordView: TextView,
        val meaningView: TextView,
        val deleteButton: ImageButton,
    ) : RecyclerView.ViewHolder(itemView) {

        init {
            deleteButton.setOnClickListener {
                val dictionaryItem : DictionaryItem = dataSet[adapterPosition]
                listener.onDeleteClick(dictionaryItem)
                dataSet.removeAt(adapterPosition)
                notifyDataSetChanged()
            }
        }

        fun bindDataSet(dictionaryItem: DictionaryItem) {
            wordView.text = dictionaryItem.word
            meaningView.text = dictionaryItem.meaning
        }
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryRecyclerWithListAdapter.ViewHolder {
        val dictionaryItemBinding = DictionaryItemCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return  ViewHolder(
            dictionaryItemBinding.DictionaryItemCard,
            dictionaryItemBinding.WordTextView,
            dictionaryItemBinding.MeaningTextView,
            dictionaryItemBinding.DeleteButton,
        )
    }

    override fun onBindViewHolder(holder: DictionaryRecyclerWithListAdapter.ViewHolder, position: Int) {
        holder.bindDataSet(dataSet[position])
    }

    fun changeDataSet(dataSet: MutableList<DictionaryItem>){
        this.dataSet = dataSet
        this.notifyDataSetChanged()
    }
}