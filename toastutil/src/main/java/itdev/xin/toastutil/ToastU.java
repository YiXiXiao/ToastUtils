package itdev.xin.toastutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xiaoyixi on 17/10/17.
 * 多样式 toast工具类
 */
@SuppressLint("InflateParams")
public class ToastU {

    @ColorInt
    private static int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");        //默认文字颜色
    @ColorInt
    private static int ERROR_COLOR = Color.parseColor("#D50000");               //错误提示默认背景颜色
    @ColorInt
    private static int INFO_COLOR = Color.parseColor("#3F51B5");                //信息提示默认背景颜色
    @ColorInt
    private static int SUCCESS_COLOR = Color.parseColor("#388E3C");             //成功提示默认背景颜色
    @ColorInt
    private static int WARNING_COLOR = Color.parseColor("#FFA900");             //警告提示默认背景颜色
    @ColorInt
    private static int NORMAL_COLOR = Color.parseColor("#353A3E");              //标准背景颜色

    //默认常规toast样式
    private static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    private static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;

    //默认字体大小
    private static int textSize = 16; // in SP
    //是否有图标,默认位true
    private static boolean tintIcon = true;

    private ToastU(){

    }

    /**
     * 纯文本常规toast
     * 默认提示时间为 LENGTH_SHORT
     * @param mContext
     * @param message
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context mContext,@NonNull CharSequence message){
        return normal(mContext, message, Toast.LENGTH_SHORT, null, false);
    }

    /**
     * 带icon的常规toast
     * * 默认提示时间为 LENGTH_SHORT
     * @param mContext
     * @param message
     * @param icon
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context mContext, @NonNull CharSequence message, Drawable icon){
        return normal(mContext, message, Toast.LENGTH_SHORT, icon, true);
    }

    /**
     * 纯文本常规toast
     * 接收指定提示时间
     * @param mContext
     * @param message
     * @param duration
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context mContext,@NonNull CharSequence message,int duration){
        return normal(mContext, message, duration, null, false);
    }

    /**
     * 带icon的常规toast
     * 接收指定提示时间
     * @param mContext
     * @param message
     * @param icon
     * @param duration
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context mContext, @NonNull CharSequence message, int duration, Drawable icon){
        return normal(mContext, message, duration, icon, true);
    }

    /**
     * 接收所有参数
     * @param mContext
     * @param message
     * @param duration
     * @param icon
     * @param withIcon
     * @return
     */
    @CheckResult
    private static Toast normal(Context mContext, CharSequence message, int duration, Drawable icon, boolean withIcon) {
        return custom(mContext, message, icon, NORMAL_COLOR, duration, withIcon, true);
    }

    /**
     * 警告纯文本toast
     * @param mContext
     * @param message
     * @return
     */
    @CheckResult
    public static Toast warning(@NonNull Context mContext, @NonNull CharSequence message) {
        return warning(mContext, message, Toast.LENGTH_SHORT, true);
    }

    /**
     * 警告纯文本
     * @param mContext
     * @param message
     * @param duration
     * @return
     */
    @CheckResult
    public static Toast warning(@NonNull Context mContext, @NonNull CharSequence message, int duration) {
        return warning(mContext, message, duration, true);
    }

    public static Toast warning(@NonNull Context mContext, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(mContext, message, ToastUUtils.getDrawable(mContext, R.drawable.ic_error_outline_white_48dp),
                WARNING_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message) {
        return info(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return info(context, message, duration, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToastUUtils.getDrawable(context, R.drawable.ic_info_outline_white_48dp),
                INFO_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message) {
        return success(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return success(context, message, duration, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToastUUtils.getDrawable(context, R.drawable.ic_check_white_48dp),
                SUCCESS_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message) {
        return error(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return error(context, message, duration, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, ToastUUtils.getDrawable(context, R.drawable.ic_clear_white_48dp),
                ERROR_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon,
                               int duration, boolean withIcon) {
        return custom(context, message, icon, -1, duration, withIcon, false);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, @DrawableRes int iconRes,
                               @ColorInt int tintColor, int duration,
                               boolean withIcon, boolean shouldTint) {
        return custom(context, message, ToastUUtils.getDrawable(context, iconRes),
                tintColor, duration, withIcon, shouldTint);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon,
                               @ColorInt int tintColor, int duration,
                               boolean withIcon, boolean shouldTint) {
        final Toast currentToast = new Toast(context);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout, null);
        final ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = (TextView) toastLayout.findViewById(R.id.toast_text);
        Drawable drawableFrame;

        if (shouldTint)
            drawableFrame = ToastUUtils.tint9PatchDrawableFrame(context, tintColor);
        else
            drawableFrame = ToastUUtils.getDrawable(context, R.drawable.toast_frame);
        ToastUUtils.setBackground(toastLayout, drawableFrame);

        if (withIcon) {
            if (icon == null)
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            if (tintIcon)
                icon = ToastUUtils.tintIcon(icon, DEFAULT_TEXT_COLOR);
            ToastUUtils.setBackground(toastIcon, icon);
        } else {
            toastIcon.setVisibility(View.GONE);
        }

        toastTextView.setTextColor(DEFAULT_TEXT_COLOR);
        toastTextView.setText(message);
        toastTextView.setTypeface(currentTypeface);
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        currentToast.setView(toastLayout);
        currentToast.setDuration(duration);
        return currentToast;
    }

    public static class Config {
        @ColorInt
        private int DEFAULT_TEXT_COLOR = ToastU.DEFAULT_TEXT_COLOR;
        @ColorInt
        private int ERROR_COLOR = ToastU.ERROR_COLOR;
        @ColorInt
        private int INFO_COLOR = ToastU.INFO_COLOR;
        @ColorInt
        private int SUCCESS_COLOR = ToastU.SUCCESS_COLOR;
        @ColorInt
        private int WARNING_COLOR = ToastU.WARNING_COLOR;

        private Typeface typeface = ToastU.currentTypeface;
        private int textSize = ToastU.textSize;

        private boolean tintIcon = ToastU.tintIcon;

        private Config() {
            // avoiding instantiation
        }

        @CheckResult
        public static Config getInstance() {
            return new Config();
        }

        public static void reset() {
            ToastU.DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
            ToastU.ERROR_COLOR = Color.parseColor("#D50000");
            ToastU.INFO_COLOR = Color.parseColor("#3F51B5");
            ToastU.SUCCESS_COLOR = Color.parseColor("#388E3C");
            ToastU.WARNING_COLOR = Color.parseColor("#FFA900");
            ToastU.currentTypeface = LOADED_TOAST_TYPEFACE;
            ToastU.textSize = 16;
            ToastU.tintIcon = true;
        }

        @CheckResult
        public Config setTextColor(@ColorInt int textColor) {
            DEFAULT_TEXT_COLOR = textColor;
            return this;
        }

        @CheckResult
        public Config setErrorColor(@ColorInt int errorColor) {
            ERROR_COLOR = errorColor;
            return this;
        }

        @CheckResult
        public Config setInfoColor(@ColorInt int infoColor) {
            INFO_COLOR = infoColor;
            return this;
        }

        @CheckResult
        public Config setSuccessColor(@ColorInt int successColor) {
            SUCCESS_COLOR = successColor;
            return this;
        }

        @CheckResult
        public Config setWarningColor(@ColorInt int warningColor) {
            WARNING_COLOR = warningColor;
            return this;
        }

        @CheckResult
        public Config setToastTypeface(@NonNull Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        @CheckResult
        public Config setTextSize(int sizeInSp) {
            this.textSize = sizeInSp;
            return this;
        }

        @CheckResult
        public Config tintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        public void apply() {
            ToastU.DEFAULT_TEXT_COLOR = DEFAULT_TEXT_COLOR;
            ToastU.ERROR_COLOR = ERROR_COLOR;
            ToastU.INFO_COLOR = INFO_COLOR;
            ToastU.SUCCESS_COLOR = SUCCESS_COLOR;
            ToastU.WARNING_COLOR = WARNING_COLOR;
            ToastU.currentTypeface = typeface;
            ToastU.textSize = textSize;
            ToastU.tintIcon = tintIcon;
        }
    }
}
