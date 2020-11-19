package cn.makn.validate.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @version V1.0
 * @description
 * @Auther: makn
 * @Date: Created by 2020/10/31 9:28
 */
@EntityScan
public class VDcit {

    /**
     * 字段编号
     * This field is V_DCIT.DCIT_ID
     * CONS: 去-的UUID
     */
    private String dcitId;

    /**
     * 字段名
     * This field is V_DCIT.DCIT_NAME
     * CONS:
     */
    private String dcitName;

    /**
     * 字段描述
     * This field is V_DCIT.DCIT_COMMENT
     * CONS:
     */
    private String dcitComment;

    /**
     * 数据类型
     * This field is V_DCIT.DATA_TYPE
     * CONS: STRING, INT, LONG, BOOLEAN, DOUBLE等
     */
    private String dataType;

    /**
     * 是否校验长度
     * This field is V_DCIT.FIXED_LENGTH
     * CONS: true-校验, false-不校验
     */
    private String fixedLength;

    /**
     * 字段长度，FIXED_LENGTH为true必输
     * This field is V_DCIT.LENGTH
     * CONS: 正整数
     */
    private String length;

    /**
     * 字段长度单位
     * This field is V_DCIT.LENGTH_UNIT
     * CONS:
     */
    private String lengthUnit;

    /**
     * 所属模块
     * This field is V_DCIT.MODULE_NAME
     * CONS: integrated-framework：框架， 其他
     */
    private String moduleName;

    /**
     * 字段枚举
     * This field is V_DCIT.RANGE
     * CONS: 对应字段枚举
     */
    private String range;

    /**
     * 字段枚举类型
     * This field is V_DCIT.RANGE_TYPE
     * CONS: ENUM-常量枚举，SQL-sql枚举
     */
    private String rangeType;

    /**
     * 数字数据范围
     * This field is V_DCIT.DCIT_SCALE
     * CONS: 数据范围用-隔开，如：1-10
     */
    private String dcitScale;

    /**
     * 是否有效校验
     * This field is V_DCIT.DCIT_valid
     * CONS: true-校验, false-不校验
     */
    private String dcitValid;

    public String getDcitId() {
        return dcitId;
    }

    public void setDcitId(String dcitId) {
        this.dcitId = dcitId;
    }

    public String getDcitName() {
        return dcitName;
    }

    public void setDcitName(String dcitName) {
        this.dcitName = dcitName;
    }

    public String getDcitComment() {
        return dcitComment;
    }

    public void setDcitComment(String dcitComment) {
        this.dcitComment = dcitComment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFixedLength() {
        return fixedLength;
    }

    public void setFixedLength(String fixedLength) {
        this.fixedLength = fixedLength;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLengthUnit() {
        return lengthUnit;
    }

    public void setLengthUnit(String lengthUnit) {
        this.lengthUnit = lengthUnit;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getRangeType() {
        return rangeType;
    }

    public void setRangeType(String rangeType) {
        this.rangeType = rangeType;
    }

    public String getDcitScale() {
        return dcitScale;
    }

    public void setDcitScale(String dcitScale) {
        this.dcitScale = dcitScale;
    }

    public String getDcitValid() {
        return dcitValid;
    }

    public void setDcitValid(String dcitValid) {
        this.dcitValid = dcitValid;
    }

    @Override
    public String toString() {
        return "VDcit{" +
                "dcitId='" + dcitId + '\'' +
                ", dcitName='" + dcitName + '\'' +
                ", dcitComment='" + dcitComment + '\'' +
                ", dataType='" + dataType + '\'' +
                ", fixedLength='" + fixedLength + '\'' +
                ", length='" + length + '\'' +
                ", lengthUnit='" + lengthUnit + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", range='" + range + '\'' +
                ", rangeType='" + rangeType + '\'' +
                ", dcitScale='" + dcitScale + '\'' +
                ", dcitValid='" + dcitValid + '\'' +
                '}';
    }
}
