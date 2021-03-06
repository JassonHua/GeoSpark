/**
 * FILE: ScatterPlot.java
 * PATH: org.datasyslab.babylon.extension.visualizationEffect.ScatterPlot.java
 * Copyright (c) 2017 Arizona State University Data Systems Lab
 * All rights reserved.
 */
package org.datasyslab.babylon.extension.visualizationEffect;

import org.apache.spark.api.java.JavaSparkContext;
import org.datasyslab.babylon.core.VisualizationOperator;
import org.datasyslab.geospark.spatialRDD.SpatialRDD;

import com.vividsolutions.jts.geom.Envelope;

/**
 * The Class ScatterPlot.
 */
public class ScatterPlot extends VisualizationOperator {
	
	/**
	 * Instantiates a new scatter plot.
	 *
	 * @param resolutionX the resolution X
	 * @param resolutionY the resolution Y
	 * @param datasetBoundary the dataset boundary
	 * @param reverseSpatialCoordinate the reverse spatial coordinate
	 * @deprecated This function always generates raster image. Please append one more parameter to the end: boolean generateVectorImage
	 */
	public ScatterPlot(int resolutionX, int resolutionY, Envelope datasetBoundary, boolean reverseSpatialCoordinate) {
		super(resolutionX, resolutionY, datasetBoundary,false,reverseSpatialCoordinate,-1,-1,false,false,false);
	}

	/**
	 * Instantiates a new scatter plot.
	 *
	 * @param resolutionX the resolution X
	 * @param resolutionY the resolution Y
	 * @param datasetBoundary the dataset boundary
	 * @param reverseSpatialCoordinate the reverse spatial coordinate
	 * @param generateVectorImage the generate vector image
	 */
	public ScatterPlot(int resolutionX, int resolutionY, Envelope datasetBoundary, boolean reverseSpatialCoordinate, boolean generateVectorImage) {
		super(resolutionX, resolutionY, datasetBoundary,false,reverseSpatialCoordinate,-1,-1,false,false,generateVectorImage);
	}
	
	/**
	 * Instantiates a new scatter plot.
	 *
	 * @param resolutionX the resolution X
	 * @param resolutionY the resolution Y
	 * @param datasetBoundary the dataset boundary
	 * @param reverseSpatialCoordinate the reverse spatial coordinate
	 * @param partitionX the partition X
	 * @param partitionY the partition Y
	 * @param parallelRenderImage the parallel render image
	 * @param generateVectorImage the generate vector image
	 */
	public ScatterPlot(int resolutionX, int resolutionY,Envelope datasetBoundary, boolean reverseSpatialCoordinate,
			int partitionX, int partitionY, boolean parallelRenderImage, boolean generateVectorImage) {
		super(resolutionX, resolutionY, datasetBoundary,false,reverseSpatialCoordinate,
			partitionX, partitionY, false, parallelRenderImage,generateVectorImage);
	}
	
	/**
	 * Instantiates a new scatter plot.
	 *
	 * @param resolutionX the resolution X
	 * @param resolutionY the resolution Y
	 * @param datasetBoundary the dataset boundary
	 * @param reverseSpatialCoordinate the reverse spatial coordinate
	 * @param partitionX the partition X
	 * @param partitionY the partition Y
	 * @param parallelRenderImage the parallel render image
	 */
	public ScatterPlot(int resolutionX, int resolutionY,Envelope datasetBoundary, boolean reverseSpatialCoordinate,
			int partitionX, int partitionY, boolean parallelRenderImage) {
		super(resolutionX, resolutionY, datasetBoundary,false,reverseSpatialCoordinate,
			partitionX, partitionY, false, parallelRenderImage,false);
	}
	
	/**
	 * Visualize.
	 *
	 * @param sparkContext the spark context
	 * @param spatialRDD the spatial RDD
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean Visualize(JavaSparkContext sparkContext, SpatialRDD spatialRDD) throws Exception {
		this.Rasterize(sparkContext, spatialRDD, true);
		this.Colorize();
		this.RenderImage(sparkContext);
		return true;
	}


}
