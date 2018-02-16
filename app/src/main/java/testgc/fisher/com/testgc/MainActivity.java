package testgc.fisher.com.testgc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class MainActivity extends AppCompatActivity {

    private CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CodeProcessor.init(this);
        codeView = (CodeView) findViewById(R.id.code_view);

//        codeView.setCode(getString(R.string.listing_py));

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode(R.string.listing_py)
                .withTheme(ColorTheme.SOLARIZED_LIGHT));

        disable(codeView);

    }


    private static void disable(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(false);
            }
        }
    }
}
