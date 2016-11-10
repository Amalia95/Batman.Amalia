package amalia.pitta.parcial.facitec.edu.pitta.op2final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by carmen on 19/10/2016.
 */
public class BatmanAdapter extends BaseAdapter {

    private List<Batman> batman;
    private Context context;


    public BatmanAdapter (List<Batman> batman, Context context){
        this.batman = batman;
        this.context= context;
    }

    @Override
    public int getCount() {return batman.size();   }

    @Override
    public Object getItem(int position) {  return batman.get(position);    }

    @Override
    public long getItemId(int position) { return batman.get(position).getId() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;


        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.
                    layout.item_layout,null);
        }

            Batman a = this.batman.get(position);


            TextView textViewTitle= (TextView) view.findViewById(R.id.textViewTitle);
            TextView tetViewYear= (TextView) view.findViewById(R.id.textViewYear);
            TextView textViewType=(TextView) view.findViewById(R.id.textViewType);
            ImageView PosterImagenView = (ImageView) view.findViewById(R.id.imageViewPoster);




            tetViewYear.setText(a.getYear());
            textViewTitle.setText(a.getTitle());
            textViewType.setText(a.getType());

        Picasso.with(this.context).load(a.getPoster()).into(PosterImagenView);

             return view;


    }
}
