freeStyleJob('freestyle job') {
    logRotator(-1, 10)
    scm {
        svn('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample')
	userName('kpandurangarao')
        password('admin@123')
    }
    steps {
        maven('clean install')
    }
}

