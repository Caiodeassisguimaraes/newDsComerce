import './styles.css'
import SearchBar from '../../../components/SearchBar';
import CatalogCard from '../../../components/CatalogCard';
import ButtonNextPage from '../../../components/ButtonNextPage';
import * as productService from '../../../services/product-service';
import { useEffect, useState } from 'react';
import { ProductDTO } from '../../../models/product';
import { isAuthenticated } from '../../../services/auth-service';

type QuerryParams = {
    page: number,
    name: string,
}

export default function Catalog() {

    const [isLastPage, setIsLastPage] = useState(false);

    const [products, setProducts] = useState<ProductDTO[]>([]);

    const [querryParams, setQuerryParams] = useState({
        page: 0,
        name: "",
    });

    useEffect(() => {
        console.log("AUTENTICADO", isAuthenticated());
        productService
            .findPageRequest(querryParams.page, querryParams.name)
            .then(response => {
                const nextPage = response.data.content;
                setProducts(products.concat(nextPage));
                setIsLastPage(response.data.last);
            });
    }, [querryParams]);

    function handleSearch(searchText: string) {
        setProducts([]);
        setQuerryParams({ ...querryParams, page: 0, name: searchText });
    }

    function handleNextPageClick() {
        setQuerryParams({ ...querryParams, page: querryParams.page + 1 });
    }

    return (

        <main>
            <section id="catalog-section" className="dsc-container">
                <SearchBar onSearch={handleSearch} />
                <div className="dsc-catalog-cards dsc-mb20 dsc-mt20">
                    {
                        products.map(product => <CatalogCard key={product.id} product={product} />)
                    }
                </div>
                {
                    !isLastPage &&
                    <div onClick={handleNextPageClick}>
                        <ButtonNextPage />
                    </div>
                }
            </section>
        </main>

    );
}