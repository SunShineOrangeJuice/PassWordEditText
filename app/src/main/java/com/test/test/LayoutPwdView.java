package com.test.test;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by admin on 2017/5/18.
 */

public class LayoutPwdView extends LinearLayout{
    private Context context;
    private EditText e1,e2,e3,e4,e5,e6;
    private String s_e1, s_e2, s_e3, s_e4, s_e5, s_e6;
    private onKeyListeners onkeylistener;
    private SixPwdListener listener;

    public LayoutPwdView(Context context) {
        super(context);
        this.context = context;
    }

    public LayoutPwdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();

    }

    public void clearedit(){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
    }


    /**
     * 取消e6的焦点
     */
    public void clearLastFouse(){
        e6.setFocusable(false);
        e6.setFocusableInTouchMode(false);
        e6.clearFocus();
    }


    public void getLastFouse(){
        e6.setFocusable(true);
        e6.setFocusableInTouchMode(true);
        e6.requestFocus();
        e6.findFocus();
    }


    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pass,this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.height = (int)context.getResources().getDimension(R.dimen.dime_52);
        view.setLayoutParams(params);
        e1 = (EditText)view.findViewById(R.id.e1);
        e2 = (EditText)view.findViewById(R.id.e2);
        e3 = (EditText)view.findViewById(R.id.e3);
        e4 = (EditText)view.findViewById(R.id.e4);
        e5 = (EditText)view.findViewById(R.id.e5);
        e6 = (EditText)view.findViewById(R.id.e6);
        onkeylistener = new onKeyListeners();
        e1.setOnKeyListener(onkeylistener);
        e2.setOnKeyListener(onkeylistener);
        e3.setOnKeyListener(onkeylistener);
        e4.setOnKeyListener(onkeylistener);
        e5.setOnKeyListener(onkeylistener);
        e6.setOnKeyListener(onkeylistener);

        e1.setCursorVisible(false);
        e2.setCursorVisible(false);
        e3.setCursorVisible(false);
        e4.setCursorVisible(false);
        e5.setCursorVisible(false);
        e6.setCursorVisible(false);
        clear_focuse();
        setaddTextChangedListener();


    }
    private  void setaddTextChangedListener(){
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (e1.getText().toString().equals("")) {
                    // heng1.setVisibility(View.VISIBLE);
                } else {
                    s_e1 = e1.getText().toString();
                    e2_focuse();
                }
            }
        });


        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (e2.getText().toString().equals("")) {
                } else {
                    s_e2 = e2.getText().toString();
                    e3_focuse();
                }
            }
        });


        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (e3.getText().toString().equals("")) {
                } else {
                    s_e3 = e3.getText().toString();
                    e4_focuse();
                }
            }
        });


        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (e4.getText().toString().equals("")) {
                } else {
                    s_e4 = e4.getText().toString();
                    e5_focuse();
                }
            }
        });


        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (e5.getText().toString().equals("")) {
                } else {
                    s_e5 = e5.getText().toString();
                    last_focuse();
                }
            }
        });


        e6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override


            public void afterTextChanged(Editable s) {
                if (e6.getText().toString().equals("")) {
                } else {
                    e6.setFocusable(false);
                    s_e6 = e6.getText().toString();
                    setLastFocuse();
                    isfirstallwrite();
                }
            }
        });
    }
    public void setLastFocuse(){
        e6.setFocusable(true);
        e6.setFocusableInTouchMode(true);
        e6.requestFocus();
        e6.findFocus();
    }


    public void  getLockTime(){
        e1.setFocusable(false);
        e2.setFocusable(false);
        e3.setFocusable(false);
        e4.setFocusable(false);
        e5.setFocusable(false);
        e6.setFocusable(false);
    }
    String eString = "";
    private void isfirstallwrite() {
        if (!TextUtils.isEmpty(s_e1) && !TextUtils.isEmpty(s_e2) && !TextUtils.isEmpty(s_e3) && !TextUtils.isEmpty(s_e4)
                && !TextUtils.isEmpty(s_e5) && !TextUtils.isEmpty(s_e6)) {
            //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            eString = s_e1 + s_e2 + s_e3 + s_e4 + s_e5 + s_e6;
            if (listener != null) {
                listener.onInputComplete(eString);
            }
        }
    }


    class onKeyListeners implements android.view.View.OnKeyListener {


        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (event.getAction() != KeyEvent.ACTION_UP) {
                    return true;
                }
                if (e6.isFocused()) {
                    if (!TextUtils.isEmpty(e6.getText())) {
                        e6.setText("");
                    } else {
                        e6.clearFocus();
                        e5_focuse();
                        e5.setText("");
                    }
                } else if (e5.isFocused()) {
                    if (!TextUtils.isEmpty(e5.getText())) {
                        e5.setText("");
                    } else {
                        e5.clearFocus();
                        e4_focuse();
                        e4.setText("");
                    }
                } else if (e4.isFocused()) {
                    if (!TextUtils.isEmpty(e4.getText())) {
                        e4.setText("");
                    } else {
                        e4.clearFocus();
                        e3_focuse();
                        e3.setText("");
                    }
                } else if (e3.isFocused()) {
                    if (!TextUtils.isEmpty(e3.getText())) {
                        e3.setText("");
                    } else {
                        e3.clearFocus();
                        e2_focuse();
                        e2.setText("");
                    }
                } else if (e2.isFocused()) {
                    if (!TextUtils.isEmpty(e2.getText())) {
                        e2.setText("");
                    } else {
                        e2.clearFocus();
                        clear_focuse();
                        e1.setText("");
                    }
                }
                return true;
            }
            return false;
        }
    }



    public void clear_focuse() {
        e1.setFocusable(true);
        e1.setFocusableInTouchMode(true);
        e1.requestFocus();
        e1.findFocus();

        InputMethodManager inputManager = (InputMethodManager) e1.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(e1, 0);

        e2.setFocusable(false);
        e3.setFocusable(false);
        e4.setFocusable(false);
        e5.setFocusable(false);
        e6.setFocusable(false);
    }

    private void e2_focuse() {
        e2.setFocusable(true);
        e2.setFocusableInTouchMode(true);
        e2.requestFocus();
        e2.findFocus();

        e1.setFocusable(false);
        e3.setFocusable(false);
        e4.setFocusable(false);
        e5.setFocusable(false);
        e6.setFocusable(false);
    }

    private void e3_focuse() {
        e3.setFocusable(true);
        e3.setFocusableInTouchMode(true);
        e3.requestFocus();
        e3.findFocus();

        e2.setFocusable(false);
        e1.setFocusable(false);
        e4.setFocusable(false);
        e5.setFocusable(false);
        e6.setFocusable(false);
    }


    private void e4_focuse() {
        e4.setFocusable(true);
        e4.setFocusableInTouchMode(true);
        e4.requestFocus();
        e4.findFocus();

        e2.setFocusable(false);
        e3.setFocusable(false);
        e1.setFocusable(false);
        e5.setFocusable(false);
        e6.setFocusable(false);
    }


    private void e5_focuse() {
        e5.setFocusable(true);
        e5.setFocusableInTouchMode(true);
        e5.requestFocus();
        e5.findFocus();


        e2.setFocusable(false);
        e3.setFocusable(false);
        e4.setFocusable(false);
        e1.setFocusable(false);
        e6.setFocusable(false);
    }


    public void last_focuse() {
        e6.setFocusable(true);
        e6.setFocusableInTouchMode(true);
        e6.requestFocus();
        e6.findFocus();

        e2.setFocusable(false);
        e3.setFocusable(false);
        e4.setFocusable(false);
        e5.setFocusable(false);
        e1.setFocusable(false);
    }

    public void setListener(SixPwdListener listener) {
        this.listener = listener;
    }
    public interface SixPwdListener{
        void onInputComplete(String passWord);
    }


}
