package rui.bean;

import rui.util.string.StringUtil;

public class COMMON_FPKJ_XMXX {

    private String XMMC;// 项目名称
    private String XMDW;// 项目单位
    private String GGXH;// 规格型号
    private String XMSL;// 项目数量
    private String XMDJ;// 项目单价
    private String XMJE;// 项目金额
    private String XMBM;// 项目编码添加 2013-11-12 吴永
    private String BYZD1;// 备用字段1
    private String BYZD2;// 备用字段2
    private String BYZD3;// 备用字段3
    private String BYZD4;// 备用字段4
    private String BYZD5;// 备用字段5
    private String SL;// 税率
    private String JLDW;// 计量单位
    private String SE;// 税额
    private String FPHXZ;// 发票行�?�质  2015�?7�?23�? 15:55:34 对接东港的需�?
    private String HSJBZ;// 发票行�?�质  2015�?7�?23�? 15:55:34 对接东港的需�?

    public String getHSJBZ() {
		return StringUtil.nullToEmpty(HSJBZ);
	}

	public void setHSJBZ(String hSJBZ) {
		HSJBZ = hSJBZ;
	}

	public String getXMMC() {
        return StringUtil.nullToEmpty(XMMC);
    }

    public void setXMMC(String xMMC) {
        XMMC = xMMC;
    }

    public String getXMDW() {
        return StringUtil.nullToEmpty(XMDW);
    }

    public void setXMDW(String xMDW) {
        XMDW = xMDW;
    }

    public String getGGXH() {
        return StringUtil.nullToEmpty(GGXH);
    }

    public void setGGXH(String gGXH) {
        GGXH = gGXH;
    }

    public String getXMSL() {
        return StringUtil.nullToEmpty(XMSL);
    }

    public void setXMSL(String xMSL) {
        XMSL = xMSL;
    }

    public String getXMDJ() {
        return StringUtil.nullToEmpty(XMDJ);
    }

    public void setXMDJ(String xMDJ) {
        XMDJ = xMDJ;
    }

    public String getXMJE() {
        return StringUtil.nullToEmpty(XMJE);
    }

    public void setXMJE(String xMJE) {
        XMJE = xMJE;
    }

    public String getXMBM() {
        return StringUtil.nullToEmpty(XMBM);
    }

    public void setXMBM(String xMBM) {
        XMBM = xMBM;
    }

    public String getBYZD1() {
        return StringUtil.nullToEmpty(BYZD1);
    }

    public void setBYZD1(String bYZD1) {
        BYZD1 = bYZD1;
    }

    public String getBYZD2() {
        return StringUtil.nullToEmpty(BYZD2);
    }

    public void setBYZD2(String bYZD2) {
        BYZD2 = bYZD2;
    }

    public String getBYZD3() {
        return StringUtil.nullToEmpty(BYZD3);
    }

    public void setBYZD3(String bYZD3) {
        BYZD3 = bYZD3;
    }

    public String getBYZD4() {
        return StringUtil.nullToEmpty(BYZD4);
    }

    public void setBYZD4(String bYZD4) {
        BYZD4 = bYZD4;
    }

    public String getBYZD5() {
        return StringUtil.nullToEmpty(BYZD5);
    }

    public void setBYZD5(String bYZD5) {
        BYZD5 = bYZD5;
    }

    public String getSL() {
        return StringUtil.nullToEmpty(SL);
    }

    public void setSL(String sL) {
        SL = sL;
    }

    public String getJLDW() {
        return StringUtil.nullToEmpty(JLDW);
    }

    public void setJLDW(String jLDW) {
        JLDW = jLDW;
    }

    public String getSE() {
        return StringUtil.nullToEmpty(SE);
    }

    public void setSE(String sE) {
        SE = sE;
    }

    public String getFPHXZ() {
        return StringUtil.nullToEmpty(FPHXZ);
    }

    public void setFPHXZ(String fPHXZ) {
        FPHXZ = fPHXZ;
    }

}
