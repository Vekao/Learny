<template> 

    <div class="section">
        <b-tabs content-class="mt-3">
            <b-tab class="nav marge" title="Schémas" active>
                <div class="cadre">
                    <figure class="img">
                        <img class="content" src="../../assets/schemas/schema_01.png" alt="Schémas tutoriel" /> 
                    </figure>
                    <div class="step">Etape 1</div>
                </div>   
            </b-tab>
            <b-tab class="nav marge" title="Photos">
                <div class="cadre">
                    <figure class="img photo">
                        <img class="content" src="../../assets/photos/photo_01.png" alt="Photos tutoriel" /> 
                    </figure>
                    <div class="step"><p>
                        Etape 1 : Lorem ipsum, dolor sit amet consectetur adipisicing elit. Sequi, quos numquam 
                        aliquid blanditiis culpa dolore error, in possimus modi ducimus laborum, alias 
                        recusandae ex sed. Consequuntur quisquam nihil illum accusantium.</p>
                    </div>
                </div>
            </b-tab>
            <b-tab  class="nav marge" title="Vidéos">
                <div>
                    <figure class="video">
                        <iframe class="cadre" width="800" height="450" src="https://www.youtube.com/embed/4Q46xYqUwZQ" frameborder="0"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </figure>
                </div>    
            </b-tab>
        </b-tabs> 
    </div>
           
</template>

<script>
import Gallery from "@/components/Gallery.vue";

export default {
    
    name: "gallery",
    components: {
    Gallery
    }

}
</script>

<style>
.nav-tabs .nav-item {
    margin-bottom: -2px;
    margin-right: 2%;
}

.nav-link {
    background-color: #f2f3f5;
}

.nav-tabs {
    border-bottom: 2px solid #323232!important;

}

.content {
    display:block;
    margin-left:auto;
    margin-right:auto;
    height: 100%;
}

.photo {
    width: 800px;
    height: auto;
}
.nav-tabs .nav-link {
    border: 1px solid #e9ecef;
    border-bottom-color: transparent;
    border-bottom-style: none;
    border-radius: 5px 5px 0 0;
    padding-bottom: 7px;
}

.nav-tabs .nav-link.active {
    border: 2px solid #323232;
    border-bottom-color: transparent;
    border-bottom-style: none;
    border-radius: 5px 5px 0 0;
    color: #323232;
    padding-bottom: 8px;
}

.nav-tabs .nav-link:hover {
    border: 1px solid #e9ecef;
    border-bottom-color: transparent;
    border-bottom-style: none;
    border-radius: 5px 5px 0 0;
    padding-bottom: 7px;
}

.nav-tabs .nav-link.active:hover {
    border: 2px solid #323232;
    border-bottom-color: transparent;
    border-bottom-style: none;
    border-radius: 5px 5px 0 0;
    color: #323232;
    padding-bottom: 8px;
}




a {
    color: #bbb;
    text-decoration: none;
}

a:hover {
    color: #7c2993;
}

</style>


<style lang="scss" scoped>
.nav {
    font-family: "Open Sans", sans-serif;
    font-size: 22px;
}

.cadre {
    border: 1px solid #707070;
    font-family: "Open Sans", sans-serif;
    font-size: 16px;
    margin-bottom: 30px;
    min-height: 450px;
}

.step {
    border-top: 1px solid #707070;
    bottom: 0;
    height: 30%;
    padding: 10px 20px;
}
.img {
    height: 70%;
    padding: 10px 20px;
    margin: 0;
}

.section {
    font-family: "Open Sans", sans-serif;
    font-size: 16px;
}

</style>
