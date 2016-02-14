package com.example.appnew;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appnew.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link ItemListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_item_detail,
				container, false);
		Log.e("Test", "Yo Inside...."+mItem);
		if (mItem != null) {
			AppServer server = new AppServer();
			Map<String,List<ContentWrapperData>> mp = server.getContent();
			if(!mp.isEmpty()){
				List<ContentWrapperData> contentList = mp.get("mItem.content");
				if(!contentList.isEmpty()){
					((TextView) rootView.findViewById(R.id.item_detail))
					.setText(contentList.get(0).getAuthor());
				}
				else
				{
					((TextView) rootView.findViewById(R.id.item_detail))
					.setText("No content Found.");
				}
			}
		}
		
		return rootView;
	}
}
