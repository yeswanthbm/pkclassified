freeStyleJob('freestyle job') {
    scm {
	svn {
		location('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample') {
                depth(SvnDepth.EMPTY)
                credentialsId('foo-password')
            }
        }
	
    }
    steps {
        maven('clean install')
    }
}

