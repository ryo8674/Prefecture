package com.example.uu119632.exercise08;

/**
 * Prefectureクラス
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/07/28
 */
class Prefecture {

    /**
     * 都道府県名
     */
    private String prefName;
    /**
     * チェック状態
     */
    private boolean isSelected;

    /**
     * 空のコンストラクタ
     */
    public Prefecture() {
    }

    /**
     * コンストラクタ
     */
    Prefecture(String prefName, boolean isSelected) {
        this.prefName = prefName;
        this.isSelected = isSelected;
    }

    /**
     * チェック状態をセット
     *
     * @param selected チェック状態
     */
    void setSelected(boolean selected) {
        isSelected = selected;
    }

    /**
     * チェック状態を取得
     *
     * @return isSelected チェック状態
     */
    boolean isSelected() {
        return isSelected;
    }

    /**
     * 都道府県名を取得
     *
     * @return prefName 都道府県名
     */
    String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名をセット
     *
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
