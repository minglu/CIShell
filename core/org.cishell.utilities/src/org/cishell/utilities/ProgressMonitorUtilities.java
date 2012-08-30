package org.cishell.utilities;

import org.cishell.framework.algorithm.AlgorithmCanceledException;
import org.cishell.framework.algorithm.ProgressMonitor;
/**
 * @deprecated see
 *             http://wiki.cns.iu.edu/display/CISHELL/2012/08/30/Future+Direction
 *             +for+CIShell+Utilities
 */
@Deprecated
public class ProgressMonitorUtilities {
	public static void handleCanceledAlgorithm(ProgressMonitor progressMonitor)
			throws AlgorithmCanceledException {
		if (progressMonitor.isCanceled()) {
			throw new AlgorithmCanceledException();
		}
	}

	public static void handlePausedAlgorithm(ProgressMonitor progressMonitor) {
		while (progressMonitor.isPaused()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
		}
	}

	public static void handleCanceledOrPausedAlgorithm(ProgressMonitor progressMonitor)
			throws AlgorithmCanceledException {
		handleCanceledAlgorithm(progressMonitor);
		handlePausedAlgorithm(progressMonitor);
	}
}