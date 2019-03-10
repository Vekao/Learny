<template>
    <figure class="thumbnail">
        <img :src="getImgUrl(img)" alt=""/>
        <figcaption>{{ title }}</figcaption>
    </figure>
    
</template>

<script>
export default {
    props: {
        img: String,
        title: String
    },
    methods: {
        getImgUrl: function(img) {
            return require('../../assets/thumbnails/' + img)
        }
    }
}
</script>

<style lang="scss" scoped>
.thumbnail {
    border-radius: 0.3em;
    height: 250px;
    width: 200px;
    overflow: hidden;
    border: 1px solid #e3e3e3;
    box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.16);
    img {
        height: 160px;
        width: 200px;
    }
    figcaption {
        text-align: center;
        font-family: 'Open sans', sans-serif;
        font-size: 1em;
        font-weight: 400;   
    }
}

</style>
