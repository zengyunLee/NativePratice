import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aaron.hulanative.R

class PopularsAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<Int, PopularsAdapter.PopularViewHolder>(PopularDiffCallback) {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class PopularViewHolder(view: View,val onClick: (String) -> Unit)  :
            RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.title)
        private var currentItem: String? = null
        init {
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener {
                currentItem?.let { onClick(it) }
            }
        }
        fun bind(title: String) {
            currentItem = title
            textView.text = title
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int):  PopularViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.popular_item_layout, viewGroup, false)
        return PopularViewHolder(view, onClick )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: PopularViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(getItem(position).toString())
    }

}

object PopularDiffCallback : DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

}
