freeStyleJob('freestyle job') {
    logRotator(-1, 10)
    scm {
        svn('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample')
	credentials('kpandurangarao')
    }
    steps {
        maven('clean install')
    }
}

