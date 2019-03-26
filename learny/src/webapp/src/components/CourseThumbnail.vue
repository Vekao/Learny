<template>
    <div class="list">
        <router-link class="clickable" to="/course">
            <figure class="thumbnail">
                <img :src="getImgUrl(img)" alt=""/>
                <figcaption>{{ title }}</figcaption>
            </figure>
        </router-link>
    </div>
   
    
</template>

<script>
export default {
    props: {
        img: String,
        title: String
    },
    methods: {
        getImgUrl: function(img) {
            return require('../../assets/thumbnails/projets/' + img)
        }
    }
}
</script>

<style lang="scss" scoped>
.thumbnail {
    border: 1px solid #e3e3e3;
    border-radius: 0.3em;
    box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.16);
    height: 250px;
    margin-bottom: 20px;
    margin-right: 50px;
    min-width: 200px;
    width: 200px;
    img {
        border-radius: 0.3em 0.3em 0 0;
        height: 160px;
        object-fit: cover;
        overflow: hidden;
        width: 100%;
    }
    figcaption {
        align-self: center;  
        font-family: 'Open sans', sans-serif;
        font-size: 1em;
        font-weight: 400;
        padding-top: 28px; 
        text-align: center;
    }
}

</style>
