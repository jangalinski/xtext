package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.net.URL;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;

@SuppressWarnings("all")
public class DelegatingClassloader extends ClassLoader {
  private CompilationTestHelper.Result classFinder;
  
  public DelegatingClassloader(final ClassLoader parent, final CompilationTestHelper.Result classFinder) {
    super(parent);
    this.classFinder = classFinder;
  }
  
  @Override
  protected URL findResource(final String name) {
    ClassLoader _classLoader = this.classFinder.getClassLoader();
    final URL result = _classLoader.getResource(name);
    URL _elvis = null;
    if (result != null) {
      _elvis = result;
    } else {
      URL _findResource = super.findResource(name);
      _elvis = _findResource;
    }
    return _elvis;
  }
  
  @Override
  public Class<?> findClass(final String name) throws ClassNotFoundException {
    Class<?> _xblockexpression = null;
    {
      final Class<?> result = this.classFinder.getCompiledClass(name);
      boolean _notEquals = (!Objects.equal(result, null));
      if (_notEquals) {
        return result;
      }
      _xblockexpression = super.findClass(name);
    }
    return _xblockexpression;
  }
  
  @Override
  public Class<?> loadClass(final String name) throws ClassNotFoundException {
    return super.loadClass(name);
  }
}
