package razerdp.demo.ui.updatetest;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import razerdp.basepopup.R;
import razerdp.demo.base.baseactivity.BaseActivity;
import razerdp.demo.popup.PopupUpdateTest;
import razerdp.demo.utils.RandomUtil;

/**
 * Created by 大灯泡 on 2020/12/29
 * <p>
 * Description：
 */
public class UpdateTestActivity extends BaseActivity {
    @BindView(R.id.tv_test)
    TextView tvTest;


    PopupUpdateTest updateTest;

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public int contentViewLayoutId() {
        return R.layout.activity_update_test;
    }

    @Override
    protected void onInitView(View decorView) {
        tvTest.setOnClickListener(v -> {
            if (updateTest == null) {
                updateTest = new PopupUpdateTest(self());
                updateTest.setOnTvChangeViewClickCallback(UpdateTestActivity.this::randomViewPosition);
                updateTest.OnUpdateClickCallback(() -> updateTest.update(v));
            }
            updateTest.showPopupWindow(v);
        });
        tvTest.post(this::randomViewPosition);
    }

    void randomViewPosition() {
        View decor = getWindow().getDecorView();
        int x = RandomUtil.randomInt(0, decor.getWidth() - tvTest.getWidth());
        int y = RandomUtil.randomInt(0, decor.getHeight() - tvTest.getHeight());
        tvTest.setTranslationX(x);
        tvTest.setTranslationY(y);
    }

}
