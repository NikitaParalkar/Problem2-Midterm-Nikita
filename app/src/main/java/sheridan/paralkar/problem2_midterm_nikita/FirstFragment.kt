package sheridan.paralkar.problem2_midterm_nikita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sheridan.paralkar.problem2_midterm_nikita.SecondFragment.Companion.COLLEGE_INFO
import sheridan.paralkar.problem2_midterm_nikita.databinding.FragmentFirstBinding
import sheridan.paralkar.problem2_midterm_nikita.model.CollegeInfo

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener { showOutput() }
        return binding.root
    }

    private fun showOutput() {
        val studentName = binding.nameInput.text.toString().trim()
        if(studentName.isEmpty()){
            val required = getString(R.string.required)
            binding.nameInput.error = required
            Toast.makeText(context, required, Toast.LENGTH_LONG).show()
        }else{
            val programList = resources.getStringArray(R.array.program_list)
            val programLength = programList[binding.programInput.selectedItemPosition]
            val collegeInfo = CollegeInfo(studentName, programLength)
            val arguments = Bundle()
            arguments.putSerializable(COLLEGE_INFO, collegeInfo)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, arguments)
        }
    }


}