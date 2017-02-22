var gulp = require('gulp');

var revCollector = require('gulp-rev-collector');

var sourcePath = {
    'layout'   : '../../src/main/resources/templates/site/layout/**/*',
    'user'     : '../../src/main/resources/templates/site/user/**/*',
    'business' : '../../src/main/resources/templates/site/business/**/*',
    'index'    : '../../src/main/resources/templates/index.html',
    'manifest' : 'dist/rev/*.json'
};

var distPath = {
    'html'     : '../src/main/resourceTest/templates/site'
};

gulp.task('replaceTpl',function(){
    setTimeout(function(){
        gulp.src([sourcePath.manifest,sourcePath.index])
            .pipe( revCollector() )
            .pipe(gulp.dest(distPath.html));
    },3000);
});