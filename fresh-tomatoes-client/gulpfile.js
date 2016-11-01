var lazyReq = require('lazy-req')(require);
var gulp = require('gulp'),
    concat = lazyReq('gulp-concat'),
    babel = require('gulp-babel'),
    autoprefixer = lazyReq('gulp-autoprefixer'),
    flatten = lazyReq('gulp-flatten'),
    del = lazyReq('del'),
    sass = lazyReq('gulp-sass'),
    connect = lazyReq('gulp-connect');
    

var jshint = require('gulp-jshint');

// Lint Task
//lint task checks any JavaScript file in our js/ directory and makes sure there are no syntax errors in our code.
gulp.task('lint', function() {
    return gulp.src('src/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// Compile Our Sass
//sass task compiles any of our Sass files in our scss/ directory into .css and saves the compiled .css file in our css/ directory.
gulp.task('sass', function() {
    return gulp.src(['src/*.scss'])
    		.pipe(sass()())
            .pipe(concat()('app.css'))
            .pipe(autoprefixer()({
                browsers: ['last 2 versions'],
                cascade: true
            }))
            .pipe(gulp.dest('dist'));
});


// Concatenate & Minify JS
gulp.task('scripts', function() {
    return gulp.src(['src/app.js' , 'src/api.js' , 'src/**/*.js'])
            .pipe(concat()('app.js'))
            .pipe(gulp.dest('dist'));
});

//Concatenate & Minify JS
gulp.task('css', function() {
    return gulp.src(['src/css/**/*.css'])
            .pipe(concat()('css/style.css'))
            .pipe(gulp.dest('dist'));
});

gulp.task('assets', function () {
    gulp.src(['index.html'])
        .pipe(gulp.dest('dist'));

    gulp.src(['src/**/*.json'])
        .pipe(flatten()())
        .pipe(gulp.dest('dist/json'));
    
    gulp.src(['src/**/*.html'])
    .pipe(flatten()())
    .pipe(gulp.dest('dist/views'));
    
    gulp.src(['src/images/**/*'])
    .pipe(flatten()())
    .pipe(gulp.dest('dist/images'));

});

// Watch Files For Changes
gulp.task('watch', function() {
    gulp.watch('src/**/*.js', ['lint', 'scripts']);
    gulp.watch('src/**/*.scss', ['sass']);
    gulp.watch('src/**/*.css', ['css']);
    gulp.watch([
        'src/**/*.html',
        '*.html',
        'src/images/**/*',
        'src/**/*.json'
    ], ['assets']);
});

//Clean
gulp.task('clean', function (cb) {
    del()(['dist/**'], cb);
});

// Default Task
gulp.task('default', ['lint','css', 'sass', 'scripts', 'assets', 'watch']);
