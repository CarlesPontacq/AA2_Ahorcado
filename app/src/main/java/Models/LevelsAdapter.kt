package Models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ahorcado.R

class LevelsAdapter(private val levels: List<Levels>) : RecyclerView.Adapter<LevelsAdapter.LevelViewHolder>() {
    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsAdapter.LevelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout_manager, parent, false)

        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelsAdapter.LevelViewHolder, position: Int) {
        val character = levels[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return levels.size
    }

    class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private  val levelWord: TextView = itemView.findViewById(R.id.levelWord);
        private  val levelDifficulty: TextView = itemView.findViewById(R.id.levelDifficulty);
        private  val levelDifficultyImage: ImageView = itemView.findViewById(R.id.dificulty_image);

        fun bind(level: Levels){
            levelWord.text = level.word
            val levelDiff = level.word.length
            levelDifficulty.text = levelDiff.toString()

            if(levelDiff > 0 && levelDiff <= 4) {
                levelDifficultyImage.setImageResource(R.drawable.ic_cielo)
            }
            else if(levelDiff > 4 && levelDiff <= 7){
                levelDifficultyImage.setImageResource(R.drawable.ic_tierra)
            }
            else if(levelDiff > 7){
                levelDifficultyImage.setImageResource(R.drawable.ic_infierno)
            }
        }
    }
}