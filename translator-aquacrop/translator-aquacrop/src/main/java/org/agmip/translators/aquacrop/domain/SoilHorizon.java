package org.agmip.translators.aquacrop.domain;

import java.util.Map;

import org.agmip.translators.aquacrop.tools.MapHelper;
import org.agmip.util.MapUtil;


@SuppressWarnings({"rawtypes", "unchecked"}) 
public class SoilHorizon {

	// extracted data
	private double soilLayerBaseDepth;
	private double soilWaterContentAtSaturation;
	private double soilWaterContentAtFieldCapacity;
	private double soilWaterContentAtPermanentWiltingPoint;
	private double saturatedHydrolicConductivity;
	
	// derived data
	private double thickness;
	private double capillaryRiseEstimationParameterA;
	private double capillaryRiseEstimationParameterB;
	private String description;
	
	
	public static SoilHorizon create(Map data) {
		SoilHorizon sh = new SoilHorizon();
		sh.from(data);
		return sh;
	}
	
	
	public void from(Map data) {
		soilLayerBaseDepth = Double.valueOf(MapUtil.getValueOr(data, "sllb", "0.0"));
		soilWaterContentAtSaturation = Double.valueOf(MapUtil.getValueOr(data, "slsat", "0.0"));
		saturatedHydrolicConductivity = Double.valueOf(MapUtil.getValueOr(data, "sksat", "0.0"));

		String wpVal = MapHelper.getValueForFirstAvailableKey(data, new String[]{"slwp", "slll"} , null);
		String fcVal = MapHelper.getValueForFirstAvailableKey(data, new String[]{"slfc1", "sldul"} , null);
		if ((wpVal != null) && (fcVal != null)) {
			soilWaterContentAtPermanentWiltingPoint = Double.valueOf(wpVal);
			soilWaterContentAtFieldCapacity = Double.valueOf(fcVal);
		} else {
			// TODO: try to look up values based on SLTX (soil type code)
			soilWaterContentAtPermanentWiltingPoint = 0.0;
			soilWaterContentAtFieldCapacity = 0.0;
		}
	}


	public double getSoilLayerBaseDepth() {
		return soilLayerBaseDepth;
	}


	public void setSoilLayerBaseDepth(double soilLayerBaseDepth) {
		this.soilLayerBaseDepth = soilLayerBaseDepth;
	}


	public double getThickness() {
		return thickness;
	}


	public void setThickness(double thickness) {
		this.thickness = thickness;
	}


	public double getSoilWaterContentAtSaturation() {
		return soilWaterContentAtSaturation;
	}


	public void setSoilWaterContentAtSaturation(double soilWaterContentAtSaturation) {
		this.soilWaterContentAtSaturation = soilWaterContentAtSaturation;
	}


	public double getSoilWaterContentAtFieldCapacity() {
		return soilWaterContentAtFieldCapacity;
	}


	public void setSoilWaterContentAtFieldCapacity(
			double soilWaterContentAtFieldCapacity) {
		this.soilWaterContentAtFieldCapacity = soilWaterContentAtFieldCapacity;
	}


	public double getSoilWaterContentAtPermanentWiltingPoint() {
		return soilWaterContentAtPermanentWiltingPoint;
	}


	public void setSoilWaterContentAtPermanentWiltingPoint(
			double soilWaterContentAtPermanentWiltingPoint) {
		this.soilWaterContentAtPermanentWiltingPoint = soilWaterContentAtPermanentWiltingPoint;
	}


	public double getSaturatedHydrolicConductivity() {
		return saturatedHydrolicConductivity;
	}


	public void setSaturatedHydrolicConductivity(
			double saturatedHydrolicConductivity) {
		this.saturatedHydrolicConductivity = saturatedHydrolicConductivity;
	}


	public double getCapillaryRiseEstimationParameterA() {
		return capillaryRiseEstimationParameterA;
	}


	public void setCapillaryRiseEstimationParameterA(
			double capillaryRiseEstimationParameterA) {
		this.capillaryRiseEstimationParameterA = capillaryRiseEstimationParameterA;
	}


	public double getCapillaryRiseEstimationParameterB() {
		return capillaryRiseEstimationParameterB;
	}


	public void setCapillaryRiseEstimationParameterB(
			double capillaryRiseEstimationParameterB) {
		this.capillaryRiseEstimationParameterB = capillaryRiseEstimationParameterB;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}