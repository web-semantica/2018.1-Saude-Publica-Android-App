package com.web.saude.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_item_detail.*
import android.support.v7.widget.RecyclerView
import com.web.saude.R
import com.web.saude.adapters.DrugstoreAdapter
import com.web.saude.dummy.DummyContent
import com.web.saude.model.Medic

class ItemDetailFragment : Fragment() {

    private var mRecyclerView: RecyclerView? = null

    private var mAdapter: DrugstoreAdapter? = null

    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = "Cardiologistas"
            }
        }
    }

    private fun setupRecycler() {

        // Configurando o gerenciador de layout para ser uma lista.
        val layoutManager = LinearLayoutManager(context)
        mRecyclerView!!.layoutManager = layoutManager

        val drugstores = ArrayList<Medic>()
        drugstores.add(Medic("Adanno Souza", R.drawable.edit_1, "10644"))
        drugstores.add(Medic("Adrino Faria", R.drawable.edit_2, "10894"))
        drugstores.add(Medic("Fatima Ferreira", R.drawable.edit_3, "29642"))

        mAdapter = DrugstoreAdapter(drugstores)
        mRecyclerView!!.adapter = mAdapter

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerView!!.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail_fragment, container, false)

        mRecyclerView = rootView.findViewById(R.id.recycler_view_layour_recycler)

        // Show the dummy content as text in a TextView.
        setupRecycler()

        return rootView
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }
}
