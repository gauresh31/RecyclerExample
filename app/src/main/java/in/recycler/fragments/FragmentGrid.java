package in.recycler.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.recycler.R;

public class FragmentGrid extends Fragment {

    private static Context context;
    private static JSONObject json;
    private static Integer[] moviesData;

    public static Fragment newInstance(Context applicationContext,
                                       String data, Integer[] movies) {
        FragmentGrid fragment = new FragmentGrid();

        try {
            json = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        moviesData = movies;
        context = applicationContext;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        ContentAdapter adapter = new ContentAdapter(json, moviesData);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView img;
        final TextView title;
        final TextView desc;


        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.list_img);
            title = (TextView) view.findViewById(R.id.list_title);
            desc = (TextView) view.findViewById(R.id.list_desc);

        }
    }

    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        JSONObject jsonObject;
        JSONArray jsonArray;
        Integer[] mov;

        public ContentAdapter(JSONObject json, Integer[] moviesData) {
            mov = moviesData;
            jsonObject = json;
            try {
                jsonArray = jsonObject.getJSONArray("results");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_list, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            JSONObject jsonData;

            try {
                jsonData = jsonArray.getJSONObject(position);

                holder.title.setText(jsonData.getString("title"));
                holder.desc.setText(jsonData.getString("overview"));

                holder.img.setImageResource(mov[position]);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            if (jsonArray == null) {
                return 0;
            } else {
                return jsonArray.length();
            }
        }
    }
}
