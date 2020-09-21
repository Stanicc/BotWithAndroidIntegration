package stanic.miris.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_config.view.*
import stanic.miris.MainActivity
import stanic.miris.R
import stanic.miris.fragment.config.CommandsConfigFragment
import stanic.miris.fragment.config.SayConfigFragment

class ConfigFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_config, container, false).apply {
            sayFragment_button.setOnClickListener {
                if (activity != null) {
                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, SayConfigFragment())
                    transaction.commit()
                }
            }
            commandsFragment_button.setOnClickListener {
                if (activity != null) {
                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, CommandsConfigFragment())
                    transaction.commit()
                }
            }

            homeButton_config.setOnClickListener {
                if (activity != null) {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            }
        }
    }

}