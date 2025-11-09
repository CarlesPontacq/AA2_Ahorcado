package Models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ahorcado.R

class LetterAdapter(
    private val letters: List<Char>,
    private val onLetterClick: (Char) -> Unit
    ) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {
    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterAdapter.LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_letter,
            parent, false)

        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterAdapter.LetterViewHolder, position: Int) {
        val letter = letters[position]
        holder.bind(letter, onLetterClick)
    }

    override fun getItemCount(): Int {
        return letters.size
    }

    class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private  val letterButton: TextView = itemView.findViewById(R.id.letterButton);

        fun bind(letter: Char, onLetterClick: (Char) -> Unit){
            letterButton.text = letter.toString()
            letterButton.setOnClickListener{
                onLetterClick(letter)
            }
        }
    }
}