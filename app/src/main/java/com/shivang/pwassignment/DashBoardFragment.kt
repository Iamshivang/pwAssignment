package com.shivang.pwassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivang.pwassignment.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment() {

    private lateinit var binding: FragmentDashBoardBinding
    private lateinit var rladapter: RecentLearningAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashBoardBinding.inflate(inflater,container,false)

        setUpViews()

        return binding.root
    }

    private fun setUpViews() {

        val recentLearningList = listOf(
            RecentLearning("System of Linear Equations", "Math Lecture - Linear Equations", 1),
            RecentLearning("Algebra Basics", "Math Lecture - Algebra", 0),
            RecentLearning("Quadratic Equations", "Math Lecture - Quadratic Equations", 1),
            RecentLearning("Probability", "Math Lecture - Probability", 0),
            RecentLearning("Derivatives", "Math Lecture - Calculus", 1),
            RecentLearning("Integration", "Math Lecture - Calculus", 0),
            RecentLearning("Trigonometry", "Math Lecture - Trigonometry", 1),
            RecentLearning("Coordinate Geometry", "Math Lecture - Geometry", 0),
            RecentLearning("Vectors", "Math Lecture - Vectors", 1),
            RecentLearning("Statistics", "Math Lecture - Statistics", 0)
        )

        rladapter = RecentLearningAdapter(recentLearningList.toMutableList())

        binding.rvRecentLearning.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rladapter
        }
    }

}