package us.bojie.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.ec.R2;
import us.bojie.latte.net.RestClient;
import us.bojie.latte.net.callback.ISuccess;

/**
 * Created by bojiejiang on 3/5/18.
 */

public class ContentDelegate extends LatteDelegate {

    @BindView(R2.id.rv_list_content)
    RecyclerView mRecyclerView;

    private static final String ARG_CONTENT_ID = "content_id";
    private int mContentId = -1;
    private List<SectionBean> mData;

    public static ContentDelegate newInstance(int contentId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID, contentId);
        final ContentDelegate delegate = new ContentDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_list_content;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        initData();
    }

    private void initData() {
        RestClient.builder()
                .url("sort_content_list.php?contentId=" + mContentId)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        mData = new SectionDataConverter().convert(response);
                        final SectionAdapter sectionAdapter =
                                new SectionAdapter(R.layout.item_section_content,
                                        R.layout.item_section_header,
                                        mData);
                        mRecyclerView.setAdapter(sectionAdapter);
                    }
                })
                .build()
                .get();
    }
}
