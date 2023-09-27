package com.tyupik.teating.ui.eating_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tyupik.teating.ui.eating_list.compose.EatingListView
import com.tyupik.teating.ui.theme.TeatingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EatingListFragment : Fragment() {

    private val viewModel: EatingListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                TeatingTheme {
                    EatingListView(viewModel)
                }
            }
        }
}