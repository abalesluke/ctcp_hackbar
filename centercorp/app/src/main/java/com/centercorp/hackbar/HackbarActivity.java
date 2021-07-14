package com.centercorp.hackbar;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebViewClient;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class HackbarActivity extends  Activity { 
	
	private Timer _timer = new Timer();
	
	private String notif = "";
	private String clipboard = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private EditText edittext1;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView menu;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear5;
	private TextView left;
	private TextView right;
	private TextView exec;
	private TextView clr;
	private TextView copy;
	private TextView paste;
	private TextView reload;
	private ScrollView vscroll3;
	private WebView webview1;
	
	private TimerTask time;
	private AlertDialog.Builder alert;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.hackbar);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		menu = (TextView) findViewById(R.id.menu);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		left = (TextView) findViewById(R.id.left);
		right = (TextView) findViewById(R.id.right);
		exec = (TextView) findViewById(R.id.exec);
		clr = (TextView) findViewById(R.id.clr);
		copy = (TextView) findViewById(R.id.copy);
		paste = (TextView) findViewById(R.id.paste);
		reload = (TextView) findViewById(R.id.reload);
		vscroll3 = (ScrollView) findViewById(R.id.vscroll3);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		alert = new AlertDialog.Builder(this);
		
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				alert.setTitle("Sorry");
				alert.setMessage("This app is still in development!\n~Anikin Luke");
				alert.setPositiveButton("bye.", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				alert.create().show();
			}
		});
		
		left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.goBack();
				edittext1.setText(webview1.getUrl());
				left.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(left, "#76ff03", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.goForward();
				edittext1.setText(webview1.getUrl());
				right.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(right, "#76ff03", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		exec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl(edittext1.getText().toString());
				exec.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(exec, "#ffff00", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		clr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText("");
				clr.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(clr, "#f50057", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		copy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", webview1.getUrl()));
				clipboard = webview1.getUrl();
				SketchwareUtil.showMessage(getApplicationContext(), "Copied!.");
				copy.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(copy, "#76ff03", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		paste.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText(clipboard);
				SketchwareUtil.showMessage(getApplicationContext(), "pasted!.");
				paste.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(paste, "#76ff03", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		reload.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl(edittext1.getText().toString());
				reload.setBackgroundColor(0xFF757575);
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_BorderLine(reload, "#76ff03", 2, 10);
							}
						});
					}
				};
				_timer.schedule(time, (int)(150));
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		_BorderLine(edittext1, "#76ff03", 3, 10);
		_BorderLine(menu, "#76ff03", 2, 10);
		_BorderLine(exec, "#ffff00", 2, 10);
		_BorderLine(clr, "#f50057", 2, 10);
		_BorderLine(left, "#76ff03", 2, 10);
		_BorderLine(right, "#76ff03", 2, 10);
		_BorderLine(linear6, "#76ff03", 2, 10);
		_BorderLine(copy, "#76ff03", 2, 10);
		_BorderLine(paste, "#76ff03", 2, 10);
		_BorderLine(reload, "#76ff03", 2, 10);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _BorderLine (final View _view, final String _color, final double _thick, final double _radius) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); gd.setCornerRadius((int)_radius); gd.setStroke((int)_thick, Color.parseColor(_color)); _view.setBackground(gd);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}