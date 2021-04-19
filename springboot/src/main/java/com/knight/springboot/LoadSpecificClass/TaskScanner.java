package com.knight.springboot.LoadSpecificClass;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TaskScanner extends PathMatchingResourcePatternResolver {

    private final String RESOURCE_PATTERN = "/**/*.class";

    private MetadataReaderFactory metadataReaderFactory;

    public TaskScanner(ApplicationContext applicationContext) {
        super(applicationContext);
        this.metadataReaderFactory = new CachingMetadataReaderFactory(applicationContext);
    }

    public List<Class> loadClassFilterByAnnotation(String packageName, Class annotationClass) throws IOException, ClassNotFoundException {
        String location = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(packageName) + RESOURCE_PATTERN;

        Resource[] resources = super.getResources(location);

        List<Class> classList = new ArrayList<>();
        for(Resource resource : resources) {

            MetadataReader metadata = metadataReaderFactory.getMetadataReader(resource);


            AnnotationMetadata classMetadata = metadata.getAnnotationMetadata();

            Set<String> annotationTypes = classMetadata.getAnnotationTypes();

            for (String annotationType : annotationTypes) {
                if (annotationType.equals(annotationClass.getName())) {
                    Class<?> targetClass = Class.forName(classMetadata.getClassName(), false, getClass().getClassLoader());
                    classList.add(targetClass);
                    break;
                }
            }

        }
        return classList;
    }


}
