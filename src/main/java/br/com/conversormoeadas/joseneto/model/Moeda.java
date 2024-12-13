package br.com.conversormoeadas.joseneto.model;

import com.google.gson.annotations.SerializedName;

public class Moeda {
	@SerializedName("base_code")
	private String baseCode;

	@SerializedName("conversion_rate")
	private Double conversionRate;

	@SerializedName("target_code")
	private String targetCode;

	public Moeda(String baseCode, Double conversionRate, String targetCode) {
		this.baseCode = baseCode;
		this.conversionRate = conversionRate;
		this.targetCode = targetCode;
	}

	public String getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}

	public Double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public String getTargetCode() {
		return targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	@Override
	public String toString() {
		return "Moeda [baseCode=" + baseCode + ", conversionRate=" + conversionRate + ", targetCode=" + targetCode
				+ "]";
	}
}
