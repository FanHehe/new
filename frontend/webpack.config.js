const fs = require('fs');
const path = require('path');
const webpack = require('webpack');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const getEntry = (source = './src/', dir = __dirname, suffix = /\.(js|css|vue)$/) => {

    dir = dir || __dirname;
    source = source || './src/';

    const p = path.resolve(dir, source);
    const list = walk(p)
        .filter(item => suffix.test(item))
        .map(item => path.relative(dir, item))
        .map(item => './' + item);

    const result = {};

    list.forEach(item => {
        result[item.substring(source.length, item.lastIndexOf('.'))] = item;
    });

    return result;
};

const getHtmlPlugins = () => {
    const p = [];
    const map = getEntry(null, null, /\.(html)$/);

    for (let key in map) {
        p.push(new HtmlWebpackPlugin({
          template: map[key],
          filename: `${key}.html`,
          inject: true,
          chunks: 'all',
        }));
    }
    return p;
}

const walk = (dir) => {
    let result = [];
    const files = fs.readdirSync(dir);

    files.forEach(function(item) {
        item = path.resolve(dir, item);
        const stat = fs.statSync(item);
        if (stat && stat.isDirectory()) {
            result = result.concat(walk(item));
        } else {
            result.push(item);
        }
    });

    return result;
};

module.exports = {
    entry: getEntry(),
    context: path.resolve(__dirname),
    devtool: 'cheap-module-eval-source-map',

    output: {
        path: path.resolve(__dirname, './dist'),
        filename: '[name].js'
    },

    module: {
        rules: [
            {
                test: /\.html$/,
                use: [ "text-loader"]
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader',
            },

            {
                test: /\.js$/,
                loader: 'babel-loader',
                include: [
                    path.resolve('./src'),
                    path.resolve('./tests'),
                ]
            },
            {
                test: /\.css$/,
                use: [
                  'style-loader',
                  'css-loader',
                  'postcss-loader'
                ]
            },
            {
                test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
                loader: 'url-loader',
                options: {
                    limit: 10000,
                    name: 'img/[name].[hash:7].[ext]'
                }
            },
            {
                test: /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
                loader: 'url-loader',
                options: {
                    limit: 10000,
                    name: 'media/[name].[hash:7].[ext]'
                }
            },
            {
                test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
                loader: 'url-loader',
                options: {
                    limit: 10000,
                    name: 'fonts/[name].[hash:7].[ext]'
                }
            }
        ]
    },
    resolve: {
        extensions: ['.js', '.json', '.vue'],
        alias: {
            'vue': 'vue/dist/vue.js'
        },
    },
    plugins: [
        new VueLoaderPlugin(),
        ...getHtmlPlugins(),
    ]
};
