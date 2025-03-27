package com.shivang.pwassignment

import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.shivang.pwassignment.databinding.ActivityInteractiveLearningBinding

class InteractiveLearning : AppCompatActivity() {

    private lateinit var binding: ActivityInteractiveLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInteractiveLearningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val options = listOf(
            binding.optionSuperiorVenaCava,
            binding.optionRightAtrium,
            binding.optionRightVentricle,
            binding.optionRightAorta,
            binding.optionLeftVentricle
        )

        val slots = listOf(
            binding.slotA,
            binding.slotB,
            binding.slotC,
            binding.slotD,
            binding.slotE
        )

        options.forEach { option ->
            option.setOnLongClickListener {
                val clipData = ClipData.newPlainText("label", option.text)
                val dragShadow = View.DragShadowBuilder(it)
                it.startDragAndDrop(clipData, dragShadow, it, 0)
                it.visibility = View.INVISIBLE
                true
            }
        }

        slots.forEach { slot ->
            slot.setOnDragListener { v, event ->
                when (event.action) {
                    DragEvent.ACTION_DROP -> {
                        val draggedText = event.clipData.getItemAt(0).text.toString()
                        val correctAnswer = v.tag.toString()

                        (v as TextView).text = draggedText
                        if (draggedText == correctAnswer) {
                            v.setTextColor(Color.GREEN)
                        } else {
                            v.setTextColor(Color.RED)
                        }
                    }
                    DragEvent.ACTION_DRAG_ENDED -> {
                        val draggedView = event.localState as View
                        draggedView.visibility = View.VISIBLE
                    }
                }
                true
            }
        }
    }
}