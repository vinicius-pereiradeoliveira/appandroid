package appsind.atom.com.br.appandroidsind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import appsind.atom.com.br.appandroidsind.R;
import appsind.atom.com.br.appandroidsind.model.Advantages;
import appsind.atom.com.br.appandroidsind.model.Campaign;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public class AdapterListCampaign extends BaseAdapter {
    private final List<Campaign> campaigns;
    private final Context context;

    public AdapterListCampaign(Context context, List<Campaign> campaigns) {
        this.context = context;
        this.campaigns = campaigns;
    }

    @Override
    public int getCount() {
        return campaigns.size();
    }

    @Override
    public Object getItem(int position) {

        return campaigns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Campaign camp = campaigns.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.advantage_list_items, parent, false);
        }

        //pegando as referências das Views
        TextView name = (TextView) view.findViewById(R.id.list_name);
        TextView description = (TextView) view.findViewById(R.id.list_description);

        //populando as Views
        name.setText(camp.getName());
        description.setText(camp.getDescription());

        return view;
    }
}
