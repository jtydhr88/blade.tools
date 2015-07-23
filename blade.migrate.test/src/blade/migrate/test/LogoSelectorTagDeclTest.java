package blade.migrate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import blade.migrate.api.Migration;
import blade.migrate.api.Problem;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class LogoSelectorTagDeclTest {

	@Test
	public void findProblems() throws Exception {
		ServiceReference<Migration> sr = context
				.getServiceReference(Migration.class);

		Migration m = context.getService(sr);

		List<Problem> problems = m.findProblems(new File("jsptests/logo-selector/"));

		assertEquals(1, problems.size());

		boolean found = false;

		for (Problem problem : problems) {
			if (problem.file.getName().endsWith("LogoSelectorTagDeclTest.jsp")
					&& problem.lineNumber == 11 && problem.startOffset == 595
					&& problem.endOffset == 637) {

				found = true;
			}
		}

		if (!found) {
			fail();
		}
	}

	private final BundleContext context = FrameworkUtil.getBundle(
		this.getClass()).getBundleContext();

}