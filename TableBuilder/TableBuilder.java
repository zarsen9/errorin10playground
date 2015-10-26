import android.app.Activity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableBuilder
{
    //create TableLayout for id
    public static TableLayout getDefaultTableLayout(Activity activity, int id)
    {
        TableLayout tv = (TableLayout) activity.findViewById(id);
        return tv;
    }

    //create TableLayout for id and remove all old views (reset)
    public static TableLayout getCleanDefaultTableLayout(Activity activity, int id)
    {
        TableLayout tv = (TableLayout) activity.findViewById(id);
        tv.removeAllViewsInLayout();
        return tv;
    }

    //createn default TableRow
    public static TableRow getDefaultTableRow(Activity activity)
    {
        TableRow tr = new TableRow(activity);
        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        return tr;
    }

    //add textview to row
    public static void addTextViewToTableRow(Activity activity, TableRow tr, String text, int textColor, int textSize, boolean padding)
    {
        if(activity != null && tr != null) {
            TextView b = new TextView(activity);
            if(text != null)
                b.setText(text);
            if(textColor > 0)
                b.setTextColor(textColor);
            if(textSize > 0)
                b.setTextSize(textSize);
            if(padding)
                b.setPadding(10, 0, 0, 0);
            tr.addView(b);
        }
    }

    //add multiple textviews to row
    public static void addTextViewsAsTableRow(Activity activity, TableLayout tv, String[] texts, int[] colors, int[] sizes, boolean padding)
    {
        if(activity != null && tv != null && texts.length==colors.length && texts.length==sizes.length)
        {
            TableRow tr = getDefaultTableRow(activity);
            for(int i = 0; i < texts.length; i++) {
                addTextViewToTableRow(activity, tr, texts[i], colors[i], sizes[i], padding);
            }
            tv.addView(tr);
        }
    }

    //add a horizontal line to the table (used to separate two rows)
    public static void addLineToTable(Activity activity, TableLayout tl, int color)
    {
        final View vline = new View(activity);
        vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
        vline.setBackgroundColor(color);
        tl.addView(vline);
    }
}
