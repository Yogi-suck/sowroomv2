package com.sowroom.app.ui.book

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sowroom.app.R
import com.sowroom.app.databinding.FragmentBookBinding
import com.sowroom.app.ui.home.MainActivity

class BookFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentBookBinding
    private val viewModel: BookViewModel by lazy { BookViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater, container, false).apply {
            viewModel= this@BookFragment.viewModel
            lifecycleOwner= this@BookFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }


    private fun init() {
        binding.recycleView.adapter = BookAdapter(parent)
        viewModel.listBook()
        binding.swipRefresh.setOnRefreshListener {
            viewModel.listBook()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipRefresh.isRefreshing = it
        }
        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}